<template>
  <section>
    Settings :O
  </section>
</template>


<script>
import auth from '../../auth'

export default {
  data() {
    return {
      me : null,
      authenticated: auth.authenticated,
    };
  },
  created(){
    this.me = auth.getProfile();
    console.log(this.me);
  }

};
</script>

<style lang="scss" scoped>
.content{

  padding-top: 50px;

  h2{
    color: #2c2d30;
    width: 100%;
    max-width: 800px;
    text-align: center;
    display: block;
    margin: auto;
    font-size: 3em;
    line-height: 80px;
    margin-bottom: 50px;
  }


}
</style>
