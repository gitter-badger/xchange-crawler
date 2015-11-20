(function () {
    'use strict';

    angular.module('cyberfund.api', ['ng'])

        .controller('homeCtrl', ['$scope', '$http', function ($scope, $http) {
            $http.get('api/markets').success(function (response) {
                $scope.items = response;
            });
        }])

}());

