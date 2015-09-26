var TesseractPlugin = {};

TesseractPlugin.getText = function(successCallback, errorCallback, options) {
    options = options || {};
    var imageString = options.imageString;
	var language = options.language;
    
    var args = [imageString, language];

    exec(successCallback, errorCallback, "TesseractPlugin", "getText", args);
};

module.exports = TesseractPlugin;
