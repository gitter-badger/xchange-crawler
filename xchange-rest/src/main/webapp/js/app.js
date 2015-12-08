(function () {
    'use strict';

    angular.module('cyberfund.api', ['ng'])

        .controller('homeCtrl', ['$scope', '$http', function ($scope, $http) {
            $http.get('api/markets').success(function (response) {
                $scope.items = response;
            });
        }])
        .filter('full', function() {
            return function(input) {
                if (!input) {
                    return '';
                }
                var precision = 0;
                while (Math.round(input * Math.pow(10, precision))/ Math.pow(10, precision) != input) {
                    precision = precision + 1;
                }
                return input.toFixed(precision);
            };
        })

}());

