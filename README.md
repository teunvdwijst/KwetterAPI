# Kwetter Backend API

## Teun van der Wijst

### S62, Fontys Eindhoven

Kwetter applicatie backend.

All API path calls are described below. All data is parsed in application/json format.

    /api

	/accounts
		/{limit}				(@GET)
		/getbyusername/{username}		(@GET)
		/getbyemail/{email}			(@GET)
		/getfollowers/{email}			(@GET)
		/getfollowing/{email}			(@GET)
		/create					(@POST)
		/update					(@POST)
		/delete					(@POST)
	
	/tweets
		/{id}					(@GET)
		/getbyuser/{limit}/{email}		(@GET)
		/getrecent/{limit}			(@GET)
		/getbytag/{limit}/{tag}			(@GET)
		/create					(@POST)
		/update					(@POST)
		/delete					(@POST)
