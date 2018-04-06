const webpack = require('webpack');
const HtmlWebpackPlugin = require('html-webpack-plugin');

module.exports = {
  devtool: 'eval-source-map',
  entry: __dirname + '/src/main/webapp/index.jsx', // 已多次提及的唯一入口文件
  output: {
    path: __dirname + '/src/main/webapp', // 打包后的文件存放的地方
    filename: 'bundle.js' // 打包后输出文件的文件名
  },
  resolve: {
    extensions: ['.js', '.jsx', '.json', 'ts', 'tsx']
  },
  module: {
    rules: [
      {
        test: /(\.jsx|\.js)$/,
        use: [
          { loader: 'babel-loader' },
          { loader: 'eslint-loader' }
        ],
        exclude: /node_modules/
      },
      {
        test: /\.tsx?$/,
        use: {
          loader: 'awesome-typescript-loader'
        },
        exclude: /node_modules/
      },
      // { test: /\.tsx?$/, loader: 'awesome-typescript-loader' },
      // { enforce: 'pre', test: /\.js$/, loader: 'source-map-loader' },
      {
        test: /\.scss$/,
        use: [{
          loader: 'style-loader' // creates style nodes from JS strings
        }, {
          loader: 'css-loader' // translates CSS into CommonJS
        }, {
          loader: 'sass-loader' // compiles Sass to CSS
        }]
      },
      {
        test: /\.(png|jpg|gif|eot|woff|woff2|svg|ttf)$/,
        use: [
          'file-loader'
        ]
      }
    ]
  },
  plugins: [
    new webpack.BannerPlugin('版权所有，翻版必究'),
    new HtmlWebpackPlugin({
      template: __dirname + '/src/main/webapp/index.tmpl.html' // new 一个这个插件的实例，并传入相关的参数
    })
    // new webpack.HotModuleReplacementPlugin() // 热加载插件
  ]
};
