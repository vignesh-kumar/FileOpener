

function FileOpener() {
};

FileOpener.prototype.open = function(fileName, contentType,subsectionJson,deviceId,rcid,userId,orgId,sid,logKey, theItemRepKey,jsonCount,filename,aContentId,callbackContext) {
    callbackContext = callbackContext || {};
    cordova.exec(callbackContext.success || null, callbackContext.error || null, "FileOpener", "open", [fileName, contentType,subsectionJson,deviceId,rcid,userId,orgId,sid,logKey,theItemRepKey,jsonCount,filename,aContentId]);
   
};

/**
 * Load Plugin
 */

if(!window.plugins) {
    window.plugins = {};
}
if (!window.plugins.fileOpener) {
    window.plugins.fileOpener = new FileOpener();
}
