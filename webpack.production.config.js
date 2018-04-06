//  webpack.production.config.js
const webpack = require('webpack');
const HtmlWebpackPlugin = require('html-webpack-plugin');
const ExtractTextPlugin = require('extract-text-webpack-plugin');

module.exports = {
    entry: __dirname + '/src/main/webapp/index.jsx', // 已多次提及的唯一入口文件
    output: {
        path: __dirname + '/src/main/webapp', // 打包后的文件存放的地方
        filename: 'bundle-[hash].js'
    },
    devtool: 'none',
    devServer: {
        contentBase: './public', // 本地服务器所加载的页面所在的目录
        historyApiFallback: true, // 不跳转
        inline: true,
        // hot: true
    },
    module: {
        rules: [{
            test: /(\.jsx|\.js)$/,
            use: {
                loader: 'babel-loader'
            },
            exclude: /node_modules/
        }, {
            test: /(\.css|\.scss)$/,
            use: ExtractTextPlugin.extract({
                fallback: 'style-loader',
                use: [
                    {
                        loader: 'css-loader',
                        options: {
                            modules: true
                        }
                    }, {
                        loader: 'sass-loader' //  compiles Sass to CSS
                    }, {
                        loader: 'postcss-loader'
                    }
                ]
            })
        }]
    },
    plugins: [
        new webpack.BannerPlugin('版权所有，翻版必究'),
        new HtmlWebpackPlugin({
            template: __dirname + '/src/main/webapp/index.html' // new 一个这个插件的实例，并传入相关的参数
        }),
        new webpack.optimize.OccurrenceOrderPlugin(), //  为组件分配ID，通过这个插件webpack可以分析和优先考虑使用最多的模块，并为它们分配最小的ID
        new webpack.optimize.UglifyJsPlugin(), //  压缩JS代码
        new ExtractTextPlugin('style.css') //  分离CSS和JS文件
    ]
};
