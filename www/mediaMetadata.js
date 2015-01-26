module.exports = {
    mediameta: function(fullpath, successCallback, errorCallback) {
        cordova.exec(
            successCallback, // success callback function
            errorCallback, // error callback function
            'MediaMetadata', // mapped to our native Java class called "MediaMetadata"
            'getMediaMetadata', // with this action name
            [{                  // and this array of custom arguments to create our entry
                "fullpath": fullpath
            }]
        );
    }
};
