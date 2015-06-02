var Q = require('q'),
    Client = require('node-rest-client').Client;

var client = new Client();

var colorServiceUrl = "http://localhost:8000";

exports.color = function () {
    var dfd = Q.defer();
    client.get(colorServiceUrl+"/v1/color", {
        requestConfig: {
            timeout:1000
        }
    }, function (data) {
        dfd.resolve(data);
    }).on('error', function (error) {
        dfd.reject(error);
    });
    return dfd.promise;
};