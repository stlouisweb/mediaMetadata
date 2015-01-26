var mediaMeta = {
    createEvent: function(fullpath, callback) {
        cordova.exec(
            callback,
            function(err) {
                callback('Nothing to echo.');
            },'MediaMetadata', // mapped to our native Java class called "CalendarPlugin"
            'getMediaMetadata', // with this action name
            [{                  // and this array of custom arguments to create our entry
                "fullpath": fullpath
            }]
        );
    }
}
module.exports = mediaMeta;