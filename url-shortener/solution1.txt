Functional:
    1. Shorten long urls to short
    2. Redirect.

Non Functional:
    1. 500M URLs per month.
    2. Fast redirects.

Calculations:
    1. Shortened URL permissible characters: [A-Z, a-z, 0-9]
    2. No of characters: 7
    3. Possible combinations: 62^7 = 3.5 Trillion
    4. Yearly 6 Billion.
    5. It takes 583 years to exhaust all possible combinations.
    6. For one record: Long URL: 1000, Short URL: 20, UserId: 20, DateTime: 8 = 1048
    7. For 1 year: 6TB of storage.

Logic:
     During service startup:
     ------------------------
     * When the shortener service instance starts up, it registers itself with a server_info table
        ID | ServerId | LastAccessed

        id column is a db auto incremental sequence.

        serverId is an external parameter a server gets when deployed (eg: via an env variable etc).

            => If a server is registered for the first time, it gets the latest seq from db (which is atomic and unique).
            => If a server is already registered then simply get the id in a subsequent query.

       URL generation algorithm:
       -------------------------
       * The id required to encode a short URL consists of the following pattern:
            <server_id>_<millis_since_custom_epoch>_<seq>_<4_digits_random_number>
            server_id: assigned and obtained during the instance start up.
            millis_since_custom_epoch: we use a custom epoch for having more head room in the future (eg: 1-Jan-2020).
            seq: a millisecond-wise atomic counter to have unique number if the more than one requests hit the same server at the same millisecond (a simple in-memory atomic counter will do).
            4_digits_random_number: For simple security reasons so that the URLs can't be guessed easily.
       * Once we have the raw id as above:
                We convert that number to Base62.














