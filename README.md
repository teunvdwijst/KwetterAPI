# Kwetter Backend API

## Teun van der Wijst

### S62, Fontys Eindhoven

Kwetter applicatie backend.

Domain model and class diagram : https://imgur.com/a/rK5km

All API path calls are described below. All data is parsed in application/json format.

    /api

	/accounts
		/{limit}			(@GET)
		/username/{username}		(@GET)
		/email/{email}			(@GET)
		/following/{email}		(@GET)
		/followers/{email}		(@GET)
		/					(@POST)
		/					(@PUT)
		/				(@DELETE)
	
	/tweets
		/{id}				(@GET)
		/user/{limit}/{email}		(@GET)
		/recent/{limit}			(@GET)
		/tag/{limit}/{tag}		(@GET)
		/				(@POST)
		/				(@PUT)
		/				(@DELETE)
