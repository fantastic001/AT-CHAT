const path = require('path');

const { VueLoaderPlugin } = require('vue-loader')


module.exports = {
  entry: './index.js',
  mode: "development",
  output: {
    filename: 'main.js',
    path: path.resolve(__dirname, 'dist')
  },
  module: {
    rules: [
      {
        test: /\.vue$/,
        use: [
          'vue-loader',
        ]
      },
      {
        test: /\.css$/,
        use: [
          'vue-style-loader',
          'css-loader',
          //'sass-loader'
        ]
      }
    ]
  },
  plugins: [
    new VueLoaderPlugin()
  ]
};
