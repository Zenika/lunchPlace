'use strict';

angular.module('simpleApp', [])
    .controller('NameController', function ($scope, $http) {

        $scope.contacts = [];

        $scope.newname = "";

        var path = document.location.hostname;

        $scope.getContactList = function() {
            var req = "http://" + path + ":8080/list";
            $http.get(req)
                .then(function (response) {
                    $scope.contacts = response.data;
                });
        };

        $scope.addContact = function () {
            var req = "http://" + path + ":8080/add?name=" + $scope.newname;
            $scope.newname = '';

            $http.get(req)
                .then(function (response) {
                    $scope.contacts = response.data;
                });
        }

    });