'use strict';

angular.module('demo.color', [])

    .controller('ColorController', function ColorController(colorService, $interval) {
        var colorController = this;

        var noColorAvailable = {
            name: 'No color available :(',
            hex: 'ccc'
        };

        colorController.color = noColorAvailable;

        function loadColor() {
            colorService.color().then(function (color) {
                colorController.color = color;
            }, function() {
                colorController.color = noColorAvailable;
            })
        }

        $interval(loadColor, 2000);
    })

    .service('colorService', function ($http, $q) {
        var colorService = this;

        colorService.color = function () {
            var dfd = $q.defer();
            $http({
                method: 'GET',
                url: '/color',
                timeout: 200
            }).success(function (data) {
                dfd.resolve(data);
            }).error(function (error) {
                dfd.reject(error);
            });
            return dfd.promise;
        };
    });