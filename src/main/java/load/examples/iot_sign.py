#!/usr/bin/env python
from datetime import datetime
import hashlib
import hmac
import requests
import sys


def sign(key, msg):
    return hmac.new(key, msg.encode("utf-8"), hashlib.sha256).digest()

def getSignatureKey(key, dateStamp, regionName, serviceName):
    kDate = sign(("AWS4" + key).encode("utf-8"), dateStamp)
    kRegion = sign(kDate, regionName)
    kService = sign(kRegion, serviceName)
    kSigning = sign(kService, "aws4_request")
    return kSigning


access_key = 'ASIAI24CD54MW4VZCQTQ'
secret_key = 'vLTv8UbD3ruENGd7dmsNdnbxCWYDLtnlMgrfc1Qx'
session_token = 'FQoDYXdzEEgaDPHHp6hRnbl1lF6q8yLKBLHm1grSM10kU1t7MT/JsoAPejFwiZcuh05jhPRPbZNos5AduMRiMLCYrg6I317zitzqbiPNhF+4+Ehgf5Hy/nYaGq5fCt7SrgJ+B16Pn9M0mDII0+ClJmQ/DV+bYSEPXRnjGOl3oiRe2pRsRcoqs5chyXJffMjSeOr9lZRHap/wignxYOHb4hMxK/dnHzOmhMg6s7v66qcw34brSq21cu5PSl4GxTLU4GKFu6ZEPCmh3zUTMIm6ybNU6aePY9r8oiLvBnJQN4v2saV9bzSVGGQ2v9sZGo9q7dxX0DxVH7Kt8LjN7+3fxYlrxHm7hja5HXAm5DF59Ha7YE2cLS9cwrRQ7C+Fo1Ad9ZznYAHcEwcWJdL/3KdiMQEuEuiTqaC4hsmCT43gung079ZjJWjie/mTIvVsN00fGkS0o/NnMI2Tg2t/PUsMvWg67gY1Qm0I58E6mxVBFWCiCHfI9N7Xv07ghainaiaxJPhkIOVJAUbEViXGRpgDxa5xidT29e5iFDFcbrNJ5dWZaCn7gO1mHxJlYLtpgOuqpW94C56xo7l9d5GZEvyQ1Ds80uHxJcN0fU8/n2z4pQEJXhlHyyZNg9xrABVYrHUDadpqt5Jlt+RqM15Pl+/2bHkteU5fZKZ5QOG1K1V1jgjiWuqMLAGtbxEdJ2FxMY5Kayiy6zFDwzkOsrSa4q6LPaVygA+dKP5ad/HX/7nPxxB+to4BabfOQe1QoIQXDsqCQEP/NJjOEVqjTbEyC/4d3ZiN8TsGt5c6x+b+Z2DqLyBY1Vco1diquwU='
method = 'GET'
region = 'us-east-1'
service = 'execute-api'
algorithm = 'AWS4-HMAC-SHA256'
host = 'ru9ur419fk.' + service + '.' + region + '.amazonaws.com'
endpoint = 'https://' + host
canonical_uri = '/dev/authentication/callback/custom-google'
canonical_querystring = ''
signed_headers = 'host;x-amz-date'


now = datetime.utcnow()
amzdate = now.strftime('%Y%m%dT%H%M%SZ')
#
datestamp = now.strftime('%Y%m%d')
#
credential_scope = datestamp + '/' + region + '/' + service + '/' + 'aws4_request'
#
canonical_headers = 'host:' + host + '\n' + 'x-amz-date:' + amzdate + '\n'
#
payload_hash = hashlib.sha256(('').encode('utf-8')).hexdigest()
#
canonical_request = method + '\n' + canonical_uri + '\n' + canonical_querystring + '\n' + canonical_headers + '\n' + signed_headers + '\n' + payload_hash



signing_key = getSignatureKey(secret_key, datestamp, region, service)

string_to_sign = algorithm + '\n' +  amzdate + '\n' +  credential_scope + '\n' +  hashlib.sha256(canonical_request.encode('utf-8')).hexdigest()



signature = hmac.new(signing_key, (string_to_sign).encode('utf-8'), hashlib.sha256).hexdigest()

authorization_header = algorithm + ' ' + 'Credential=' + access_key + '/' + credential_scope + ', ' +  'SignedHeaders=' + signed_headers + ', ' + 'Signature=' + signature
headers = {
    'x-amz-date': amzdate,
    'Authorization': authorization_header,
    'x-amz-security-token': session_token,
}

r = requests.get(endpoint + canonical_uri, headers=headers)

print(r.status_code)
print(r.headers)
print(r.content)