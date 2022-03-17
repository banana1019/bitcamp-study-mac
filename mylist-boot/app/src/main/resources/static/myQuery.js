function myQuery(selector) {
  var e = document.querySelector(selector);
  
  e.css = function(name, value) {
    e.style[name] = value;
  };
  
  return e;
}

var $ = myQuery;