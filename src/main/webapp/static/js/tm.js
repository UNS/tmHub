$(document).ready(function() {
	'use strict';
	var o = {};

	o.profile = Backbone.Model.extend({
		defaults: {
			name: 'nikolay',
			email: 'mail@mail.com'
		},
		urlRoot: '/tmhub/profiles' 
	});

	o.tm = Backbone.Model.extend({urlRoot: '/tmhub/tms'});
	o.state = Backbone.Model.extend({urlRoot: '/tmhub/states'});
	
	var profile = new o.profile({login: 'remal'});
	console.log(JSON.stringify(profile));
	profile.save();
		
	var tm = new o.tm({owner: profile.get('id')});
	console.log(JSON.stringify(tm));
	tm.save();

	var state = new o.state({tm: tm.get('id')});
	state.set({nextState: 2});	
	state.save();
	console.log(JSON.stringify(state));
});