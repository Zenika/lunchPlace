<template>
  <section>

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
section{

  background: black;
  height: 100%;
}
</style>
