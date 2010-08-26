try
{
	// JS namespacing...
	
	if ('undefined' == typeof net || null == net)
	{
	  net = new Object();
	}
	if ('undefined' == typeof net.wessendorf || null == net.wessendorf)
	{
	  net.wessendorf = new Object();
	}

	
	/**
	 * Registration of the callback (+ URL)
	 */
	net.wessendorf.init = function(url, callback)
	{
      var outerFrame = document.createElement("iframe");
      outerFrame.height = "0px";
      outerFrame.width = "0px";

	  var frameName = "net::wessendorf::atmosphere";
	  var iframe = document.createElement("iframe");
	  iframe.id = frameName;
	  iframe.name = frameName;
	  iframe.height = "0px";
	  iframe.width = "0px";
	  iframe.frameBorder = "0";

	  net.wessendorf._callback = callback;
	  
	  outerFrame.appendChild(iframe);

	  document.getElementsByTagName("body").item(0).appendChild(outerFrame);

	  var iframeWindow = window.frames[frameName];
	  
	  iframeWindow.location.replace(url);
	  
	}

	/**
	 * Invoke the underlying callback!
	 */
	net.wessendorf.processStreamData = function(payload)
	{
      net.wessendorf._callback.call(this, payload);
	}
}
// play nice: tell what's going on...
catch(e)
{
alert("ERROR: " + e);
}
