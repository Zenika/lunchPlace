import router from './Router';


var options = {
  language: 'fr',
  allowSignUp: false,
  rememberLastLogin: false,
  auth: {
    redirect: false
  },
  theme: {
    primaryColor: '#0EB984'
  }
};

var lock = new Auth0Lock(
  process.env.Auth0_CLIENT_ID,
  process.env.Auth0_CLIENT_DOMAIN,
  options
);

lock.on("authenticated", function(authResult) {
  lock.getUserInfo(authResult.accessToken, function(error, profile) {
    if (error) { console.log(error); return; }

    //Save user and token
    localStorage.setItem('accessToken', authResult.accessToken);
    localStorage.setItem('profile', JSON.stringify(profile));

    //Send user to api
    let data = JSON.stringify({
      'profile' : profile,
      'accessToken' : authResult.accessToken
    });

    fetch(process.env.API_URL+"/user_connected",{method: "POST",body:data})
    .then(function(res){
      console.log(res)
      router.go('/home')
    })
    .catch((error)=>{
      console.log(error)
      router.go('/home')
    });

  });
});

const auth = {

  authenticated: !!localStorage.getItem('accessToken'),

  lock : lock,

  // To log out, we just need to remove the token
  logout() {
    localStorage.removeItem('accessToken')
    localStorage.removeItem('profile')
    this.authenticated = false
    router.go('/home')
  },

  checkAuth() {
    var jwt = localStorage.getItem('accessToken')
    if(jwt) {
      this.authenticated = true
    }
    else {
      this.authenticated = false
    }
    return !!jwt;
  },

  getToken() {
    return localStorage.getItem('accessToken')
  },

  getProfile() {
    return JSON.parse(localStorage.getItem('profile'))
  },

  // The object to be passed as a header for authenticated requests
  getAuthHeader() {
    return 'Bearer ' + localStorage.getItem('accessToken');
  },
}

export default auth;
