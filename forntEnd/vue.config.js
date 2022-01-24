/*
 * @Author: WangJunLiang
 * @Date: 2022-01-24 16:37:05 
 * @Last Modified by: WangJunLiang
 * @Last Modified time: 2022-01-24 16:44:05
 */
module.exports = {
  
  // pwa Config
  pwa: {
    //name: 'spring-vue-example',  //启动页名称
    //themeColor: '#4DBA87',  //启动页背景颜色
    //msTileColor: '#000000', //状态栏颜色
    appleMobileWebAppCapable: 'yes',   //删除默认苹果工具栏 yes or no
    appleMobileWebAppStatusBarStyle: 'default', //导航栏延时 black or default
    assetsVersion:2, //当前版本
    // configure the workbox plugin GenerateSW创建新的serverworker.js   InjectManifest现有的serverworker.js
    workboxPluginMode: 'GenerateSW',
    workboxOptions: {
      // InjectManifest模式指定server-worker路径
      // swSrc: 'dev/sw.js',
    },
    //设置图标
    /*iconPaths: {
      favicon32: 'icon.png',
      favicon16: 'icon.png',
      appleTouchIcon: 'icon.png',
      maskIcon: 'icon.png',
      msTileImage: 'icon.png'
    }*/
    //可在此直接配置manifestOptions
    manifestOptions: {
      name: 'spring-vue-example', //启动页名称
      short_name: "spring-vue-example", //简称
      background_color: "#FFFFFF", //启动页背景颜色
      theme_color: "#00000000", //状态栏颜色
      //description: "A simply readable Hacker News app.",  //描述
      display: "standalone", //显示模式
      /*fullscreen 占满怎个屏幕
      standalone 隐藏浏览器UI
      minimal-ui 显示形式也上面相似，不同浏览器不同
      browser 与普通网页在浏览器中打开一致*/
      //start_url:"",//打开页面地址
      //设置图标
      "icons": [{
                  "src": "icon.png",
                  "sizes": "48x48",
                 },{
                  "src": "icon.png",
                  "sizes": "48x48",
                  "type": "image/png"
                }, {
                  "src": "icon.png",
                  "sizes": "72x72",
                  "type": "image/png"
                }, {
                  "src": "icon.png",
                  "sizes": "96x96",
                  "type": "image/png"
                }, {
                  "src": "icon.png",
                  "sizes": "144x144",
                  "type": "image/png"
                }, {
                  "src": "icon.png",
                  "sizes": "168x168",
                  "type": "image/png"
                }, {
                  "src": "icon.png",
                  "sizes": "192x192",
                  "type": "image/png"
                }],
    },


  },
  publicPath: "./", // 构建好的文件输出到哪里
}