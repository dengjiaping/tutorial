/**
 * Created by patrick on 14-10-14.
 */
var fs = require('fs');

fs.readFile('101_1.js', 'utf8', function(err, a) {
    fs.readFile('simpleserver.js', 'utf8', function(err, b) {
        fs.readFile('app.js', 'utf8', function(err, c) {
            // oh ooooh... hope we dont do anymore async
            // as im running out of window space
            var result = a+b+c;
            // we didnt even do error handling :(
        });
    });
});