const { createProxyMiddleware } = require('http-proxy-middleware');

module.exports = function(app) {
  app.use(
    createProxyMiddleware("/admin", {
      target: "http://localhost:8091",
      changeOrigin: true,
      pathRewrite: { "^/admin": "" },
    })
  );

  app.use(
    createProxyMiddleware("/user", {
      target: "http://localhost:8090",
      changeOrigin: true,
      pathRewrite: { "^/user": "" },
    })
  );
};

