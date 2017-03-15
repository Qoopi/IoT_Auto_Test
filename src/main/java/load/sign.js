'use strict';

const crypto = require('crypto-js');

function pad(n) {
    return n < 10 ? '0' + n : n+''
}

function ISODateTimeString(d) {
    return d.getUTCFullYear()
        + pad(d.getUTCMonth() + 1)
        + pad(d.getUTCDate()) + 'T'
        + pad(d.getUTCHours())
        + pad(d.getUTCMinutes())
        + pad(d.getUTCSeconds()) + 'Z'
}

function ISODateString(d) {
    return d.getUTCFullYear()
        + pad(d.getUTCMonth() + 1)
        + pad(d.getUTCDate())
}

function getSignatureKey(key, dateStamp, regionName, serviceName) {
    var kDate = crypto.algo.HMAC.create(crypto.algo.SHA256, 'AWS4' + key).update(dateStamp).finalize();
    var kRegion = crypto.algo.HMAC.create(crypto.algo.SHA256, kDate).update(regionName).finalize();
    var kService = crypto.algo.HMAC.create(crypto.algo.SHA256, kRegion).update(serviceName).finalize();
    var kSigning = crypto.algo.HMAC.create(crypto.algo.SHA256, kService).update('aws4_request').finalize();

    return kSigning;
}

export default function sign(access_key, secret_key, session_token, host, method, canonical_uri, canonical_querystring = '', payload = '') {
    //host = '60sglz9l5h.execute-api.us-east-1.amazonaws.com';
    //method = 'GET';
    //canonical_uri = '/dev/menu';
    //access_key = 'ASIAJ6A2NZB45PDFS3QQ';
    //secret_key = 'MUM6wTw+L2Vfs5ECe7gaAodgQ3usZ5fzPuUuLffx';
    //session_token = 'FQoDYXdzEOz//////////wEaDHq9aScEuL4+uZoe9CKCBQP65oDNEWPRSbP99C4ASOOR4wLMdyAsnc+CMZnGBYW4BeBEYzqdGri7kAXx1Lfgeb7COqyImENzOnr0M4B6v4+hKDtHw1a4QNMzfDLefGL4cK7U8biwLkhftbkdHH8iDLFlnyFMqVuzf7a1QEZd2yQUwwefv9AiFa73GnVxUStuNJ6cFMpVAXvemRIxRttxLUSE9YMJHn76waB+PSkCBv/BLJIiOQCJ4yCPiVJ4y11wYpJvEoNlXPxV1GJgX1xsIocXs9yTcuw4mTasctF9Dk7PU1rGmhZCrGkRqZvBGZ1N8OK8xDtycK/zySP6Gg4xN9L2wI0vntVrdPvcBbIVBUg6d7rmRTdcjpSRQHewwvEqni/vm3vBHiqhD+1z5xoQO62AVq+93KtyL1oVXgkmcJCVu5NfevO2c0my3+fu89esyadgjdmb/U+RxDJz7X3gdwYXEawpT8KgGQsQ+8nhYs73u87yWl+Xpi5oP5CdIwIMk/NIzQQSJ+qSj5V4wacT1Vu0diezkXOD02UbtzEJ+SFt/y1e2kfBHQ3zLVYvgXEoUIo/ipp11qn4llmGOJybsFLJJl6FnRXSrh2noy6fN7M3ogrl+JPBHThFFQ2EcNdTfYZdzsWn9FhMyyyAAcsTLyionrPVKRywZxLa0KVfKOmXmSeSCZeg+D9LaXtWn7ZqJvgJd0ZAEL2Vu+EN2pbty1DvLHy/7rwDFEJ6oqNdOBFxLWi7tba613dbTLaOgYU3mqHvS+PrltUy392JzI2V8lauhB68103YHbmBKAsgRuxX5KlDCo/zRIafaIIupgh6Jta1yFhGlDdXXtBsvtfyJw/AuDsNIBYIoB/vcyzfoYPBzCi3gbi8BQ==';
    //canonical_querystring = '';
    //access_key = access_key || 'ASIAI24CD54MW4VZCQTQ';
    //secret_key = secret_key || 'vLTv8UbD3ruENGd7dmsNdnbxCWYDLtnlMgrfc1Qx';
    //session_token = session_token || 'FQoDYXdzEEgaDPHHp6hRnbl1lF6q8yLKBLHm1grSM10kU1t7MT/JsoAPejFwiZcuh05jhPRPbZNos5AduMRiMLCYrg6I317zitzqbiPNhF+4+Ehgf5Hy/nYaGq5fCt7SrgJ+B16Pn9M0mDII0+ClJmQ/DV+bYSEPXRnjGOl3oiRe2pRsRcoqs5chyXJffMjSeOr9lZRHap/wignxYOHb4hMxK/dnHzOmhMg6s7v66qcw34brSq21cu5PSl4GxTLU4GKFu6ZEPCmh3zUTMIm6ybNU6aePY9r8oiLvBnJQN4v2saV9bzSVGGQ2v9sZGo9q7dxX0DxVH7Kt8LjN7+3fxYlrxHm7hja5HXAm5DF59Ha7YE2cLS9cwrRQ7C+Fo1Ad9ZznYAHcEwcWJdL/3KdiMQEuEuiTqaC4hsmCT43gung079ZjJWjie/mTIvVsN00fGkS0o/NnMI2Tg2t/PUsMvWg67gY1Qm0I58E6mxVBFWCiCHfI9N7Xv07ghainaiaxJPhkIOVJAUbEViXGRpgDxa5xidT29e5iFDFcbrNJ5dWZaCn7gO1mHxJlYLtpgOuqpW94C56xo7l9d5GZEvyQ1Ds80uHxJcN0fU8/n2z4pQEJXhlHyyZNg9xrABVYrHUDadpqt5Jlt+RqM15Pl+/2bHkteU5fZKZ5QOG1K1V1jgjiWuqMLAGtbxEdJ2FxMY5Kayiy6zFDwzkOsrSa4q6LPaVygA+dKP5ad/HX/7nPxxB+to4BabfOQe1QoIQXDsqCQEP/NJjOEVqjTbEyC/4d3ZiN8TsGt5c6x+b+Z2DqLyBY1Vco1diquwU=';
   //var method = 'GET',
    var region = 'us-east-1';
    var service = 'execute-api';

    //host = 'ru9ur419fk.' + service + '.' + region + '.amazonaws.com',
    //var endpoint = 'https://' + host;
// ************* TASK 1: CREATE A CANONICAL REQUEST *************
// http://docs.aws.amazon.com/general/latest/gr/sigv4-create-canonical-request.html
// Step 1 is to define the verb (GET, POST, etc.)--already done.
// Step 2: Create canonical URI--the part of the URI from domain to query
// string (use '/' if no path)
//    var canonical_uri = '/dev/authentication/callback/custom-google';
// Create the canonical query string. In this example (a GET request),
// request parameters are in the query string. Query string values must
// be URL-encoded (space=%20). The parameters must be sorted by name.
// For this example, the query string is pre-formatted in the request_parameters variable.
//    var canonical_querystring = '';
// Create the list of signed headers. This lists the headers
// in the canonical_headers list, delimited with ';' and in alpha order.
// Note: The request can include any headers; canonical_headers and
// signed_headers lists those that you want to be included in the
// hash of the request. 'Host' and 'x-amz-date' are always required.
    var signed_headers = 'host;x-amz-date';
//Create a date for headers and the credential string
    var now = new Date();
    //now = new Date(144940000000);
    var amzdate = ISODateTimeString(now);
    //amzdate = '19740805T160640Z';
    var datestamp = ISODateString(now);
// Match the algorithm to the hashing algorithm you use, either SHA-1 or
// SHA-256 (recommended)
    var algorithm = 'AWS4-HMAC-SHA256';
    var credential_scope = datestamp + '/' + region + '/' + service + '/' + 'aws4_request';
// Step 4: Create the canonical headers and signed headers. Header names
// and value must be trimmed and lowercase, and sorted in ASCII order.
// Note that there is a trailing \n.
    var canonical_headers = 'host:' + host + '\n' + 'x-amz-date:' + amzdate + '\n';
// Create payload hash (hash of the request body content). For GET
// requests, the payload is an empty string ('').
    var payload_hash = crypto.algo.SHA256.create().update(payload).finalize().toString(crypto.enc.Hex);
// Combine elements to create create canonical request
    var canonical_request = method + '\n' + canonical_uri + '\n' + canonical_querystring + '\n' + canonical_headers + '\n' + signed_headers + '\n' + payload_hash;

    var signing_key = getSignatureKey(secret_key, datestamp, region, service);

    var string_to_sign = algorithm + '\n' + amzdate + '\n' + credential_scope + '\n' + crypto.algo.SHA256.create().update(canonical_request).finalize().toString(crypto.enc.Hex);

    var signature = crypto.algo.HMAC.create(crypto.algo.SHA256, signing_key).update(string_to_sign).finalize().toString(crypto.enc.Hex);

    var authorization_header = algorithm + ' ' + 'Credential=' + access_key + '/' + credential_scope + ', ' + 'SignedHeaders=' + signed_headers + ', ' + 'Signature=' + signature;
    var headers = {
        'x-amz-date': amzdate,
        'Authorization': authorization_header,
        'x-amz-security-token': session_token
    };

return headers;


}
//sign('ASIAJ6A2NZB45PDFS3QQ','MUM6wTw+L2Vfs5ECe7gaAodgQ3usZ5fzPuUuLffx','FQoDYXdzEOz//////////wEaDHq9aScEuL4+uZoe9CKCBQP65oDNEWPRSbP99C4ASOOR4wLMdyAsnc+CMZnGBYW4BeBEYzqdGri7kAXx1Lfgeb7COqyImENzOnr0M4B6v4+hKDtHw1a4QNMzfDLefGL4cK7U8biwLkhftbkdHH8iDLFlnyFMqVuzf7a1QEZd2yQUwwefv9AiFa73GnVxUStuNJ6cFMpVAXvemRIxRttxLUSE9YMJHn76waB+PSkCBv/BLJIiOQCJ4yCPiVJ4y11wYpJvEoNlXPxV1GJgX1xsIocXs9yTcuw4mTasctF9Dk7PU1rGmhZCrGkRqZvBGZ1N8OK8xDtycK/zySP6Gg4xN9L2wI0vntVrdPvcBbIVBUg6d7rmRTdcjpSRQHewwvEqni/vm3vBHiqhD+1z5xoQO62AVq+93KtyL1oVXgkmcJCVu5NfevO2c0my3+fu89esyadgjdmb/U+RxDJz7X3gdwYXEawpT8KgGQsQ+8nhYs73u87yWl+Xpi5oP5CdIwIMk/NIzQQSJ+qSj5V4wacT1Vu0diezkXOD02UbtzEJ+SFt/y1e2kfBHQ3zLVYvgXEoUIo/ipp11qn4llmGOJybsFLJJl6FnRXSrh2noy6fN7M3ogrl+JPBHThFFQ2EcNdTfYZdzsWn9FhMyyyAAcsTLyionrPVKRywZxLa0KVfKOmXmSeSCZeg+D9LaXtWn7ZqJvgJd0ZAEL2Vu+EN2pbty1DvLHy/7rwDFEJ6oqNdOBFxLWi7tba613dbTLaOgYU3mqHvS+PrltUy392JzI2V8lauhB68103YHbmBKAsgRuxX5KlDCo/zRIafaIIupgh6Jta1yFhGlDdXXtBsvtfyJw/AuDsNIBYIoB/vcyzfoYPBzCi3gbi8BQ==','60sglz9l5h.execute-api.us-east-1.amazonaws.com','GET','/dev/menu','');
