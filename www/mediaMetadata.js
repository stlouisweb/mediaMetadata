
window.MediaMeta = {
    createEvent: function(fullpath, successCallback, errorCallback) {
        cordova.exec(
            successCallback(trackinfo), // success callback function
            errorCallback, // error callback function
            'MediaMetadata', // mapped to our native Java class called "MediaMetadata"
            'getMediaMetadata', // with this action name
            [{                  // and this array of custom arguments to create our entry
                "fullpath": fullpath
            }]
        );
    }
}
module.exports = MediaMeta;