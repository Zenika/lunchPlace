var merge = require('webpack-merge')
var prodEnv = require('./prod.env')

module.exports = merge(prodEnv, {
  NODE_ENV: '"development"',
  API_URL: '"http://lunchplace-rct.wip.devlab722.net/api/v1"',
  Auth0_CLIENT_ID : '"AsIoO5G7eebq1sLDRNYWpv5W8sPDu9qM"',
  Auth0_CLIENT_DOMAIN : '"lunchplace.eu.auth0.com"',
})
