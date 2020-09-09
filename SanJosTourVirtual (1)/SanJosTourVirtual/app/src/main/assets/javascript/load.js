function loading(uri){
        var _bi=window.navigator.userAgent.toLowerCase();
		var _eq="";
		var _br="";
		var _hd=document.getElementsByTagName("HEAD");
        if(_bi.indexOf("applewebkit")>0){
            //safari & chrome
            if(_bi.indexOf("chrome")>0){
                _br="chrome";
                //just on pc temporary
                _eq="pc";
            }else{
                _br="safari";
                if(_bi.indexOf("ipad")>0){
                    _eq="ipad";
                }else if(_bi.indexOf("iphone")>0 || _bi.indexOf("ipod")>0){
                    _eq="iphone";
                }else{
                    _eq="pc";
                }
            }
        }else if(_bi.indexOf("firefox")>0){
            _eq="pc";
			_br="firefox"
            //firefox
        }else if(_bi.indexOf("msie")>0){
            //ie
			_eq="pc";
			_br="ie";
        }else{
            //opera
        }
			
		var _=document.createElement("link");
		_.type="text/css";
		_.rel="stylesheet";
		_.charset="utf-8";
		if(_eq=="iphone"){
			_.href="style/tws.css";
		}else{
			_.href="style/tw.css";
		}
		_hd.item(0).appendChild(_);

		if(_br=="safari"){
			var __=document.createElement("script");
			__.type="text/javascript";
			__.src="javascript/tw-min.js";
			_hd.item(0).appendChild(__);
			__.addEventListener("load",function(){ps.xml.loadXML(uri);},false)
		}else{
			try{
			var _d=document.createElement("div");
			_d.className="divBrowserInfo";
			_d.innerHTML="safari only";
			document.body.appendChild(_d);
			}catch(e){alert(e)}
		}
}