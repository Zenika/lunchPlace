<template>
  <header>
    <a id="logo" href="/">
      <img src="/static/logo.png">
      <span>Lunch Place</span>
    </a>
    <ul id="nav" style="display:none;">
      <li>
        <form id="search-form">
          <span class="algolia-autocomplete" style="position: relative; display: inline-block; direction: ltr;"><input type="text" id="search-query-nav" class="search-query st-default-search-input aa-input" autocomplete="off" spellcheck="false" dir="auto" style="position: relative; vertical-align: top;"><pre aria-hidden="true" style="position: absolute; visibility: hidden; white-space: pre; font-family: BlinkMacSystemFont; font-size: 11px; font-style: normal; font-variant-ligatures: normal; font-variant-caps: normal; font-weight: normal; word-spacing: 0px; letter-spacing: normal; text-indent: 0px; text-rendering: auto; text-transform: none;"></pre><span class="aa-dropdown-menu" style="position: absolute; top: 100%; z-index: 100; display: none; left: 0px; right: auto;"><div class="aa-dataset-0"></div></span></span>
        </form>
      </li>
      <li><a href="/admin/" class="nav-link">Admin</a></li>
    </ul>
  </header>
</template>

<script>
export default {

};
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style lang="scss" scoped>

  header{
    position: fixed;
    width: 100%;
    top: 0;
    background-color: #fff;
    padding: 10px 60px;
    position: relative;
    box-shadow: 0 0 1px rgba(0,0,0,0.25);
    transition: background-color 0.3s ease-in-out;
    z-index: 2;

    #logo {
      display: inline-block;
      font-size: 1.5em;
      line-height: 40px;
      color: #2c3e50;
      font-family: 'Dosis', 'Source Sans Pro', 'Helvetica Neue', Arial, sans-serif;
      font-weight: 500;
    }

    #logo img {
      vertical-align: middle;
      margin-right: 6px;
      width: 40px;
      height: 40px;
      transform: rotate(180deg);
    }
  }

</style>
