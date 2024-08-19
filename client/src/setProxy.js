const { createProxyMiddleware } = require('http-proxy-middleware');

module.exports = function(app) {
  app.use(
    createProxyMiddleware("/admin", {
      target: process.env.REACT_APP_ADMIN_API_URL,
      changeOrigin: true,
      pathRewrite: { "^/admin": "" },
    })
  );

  app.use(
    createProxyMiddleware("/user", {
      target:  process.env.REACT_APP_USER_API_URL,
      changeOrigin: true,
      pathRewrite: { "^/user": "" },
    })
  );
};

