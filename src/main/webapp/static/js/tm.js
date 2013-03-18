$(document).ready(function() {
	'use strict';
	var tm = {};

	tm.profile = Backbone.Model.extend({
		defaults: {
			name: 'nikolay',
			email: 'mail@mail.com'
		},
		urlRoot: '/tmhub/profiles' 
	});

	var p = new tm.profile({login: 'remal'});
	console.log(JSON.stringify(p));
	p.save();
	var p2 = new tm.profile({id: p.get('id')});
	p2.fetch();
	console.log(JSON.stringify(p2));
	p2.set({name: 'vasya'});
	p2.save();

	var p3 = new tm.profile({id: p2.get('id')});
	p3.fetch();
	console.log(JSON.stringify(p3));
});