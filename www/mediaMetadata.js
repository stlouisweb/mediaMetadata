var mediaMeta = {
    createEvent: function(fullpath, successCallback, errorCallback) {
        cordova.exec(
            successCallback, // success callback function
            errorCallback, // error callback function
            'MediaMetadata', // mapped to our native Java class called "CalendarPlugin"
            'getMediaMetadata', // with this action name
            [{                  // and this array of custom arguments to create our entry
                "fullpath": fullpath
            }]
        );
    }
}
module.exports = mediaMeta;