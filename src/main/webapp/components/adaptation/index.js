
(function(window, document) {
  var docEl = document.documentElement;
  var dpr;

  // set scale = 1 / dpr;
  function setScale() {
    var scale;
    if (!dpr && !scale) {
      // var isAndroid = window.navigator.appVersion.match(/android/gi);
      var isIPhone = window.navigator.appVersion.match(/iphone/gi);
      var devicePixelRatio = window.devicePixelRatio;
      if (isIPhone) {
        // iOS下，对于2和3的屏，用2倍的方案，其余的用1倍方案
        if (devicePixelRatio >= 3 && (!dpr || dpr >= 3)) {
          dpr = 3;
        } else if (devicePixelRatio >= 2 && (!dpr || dpr >= 2)) {
          dpr = 2;
        } else {
          dpr = 1;
        }
      } else {
        dpr = 1;
      }
      // 令页面宽375
      dpr = 1;
      scale = 1 / dpr;
    }
    var metaEl = document.createElement('meta');
    metaEl.setAttribute('name', 'viewport');
    metaEl.setAttribute('content', 'initial-scale=' + scale +
    ', maximum-scale=' + scale +
    ', minimum-scale=' + scale +
    ', user-scalable=no');
    if (docEl.firstElementChild) {
      docEl.firstElementChild.appendChild(metaEl);
    } else {
      var wrap = document.createElement('div');
      wrap.appendChild(metaEl);
      document.write(wrap.innerHTML);
    }
    docEl.style.dataDpr = dpr;
  }
  setScale();

  // set 1rem = viewWidth / 10
  function setRemUnit() {
    var rem = docEl.clientWidth / 10;
    docEl.style.fontSize = rem + 'px';
  }
  setRemUnit();

  window.onresize = function() {
    docEl = document.documentElement;
    setRemUnit();
  };
})(window, document);
