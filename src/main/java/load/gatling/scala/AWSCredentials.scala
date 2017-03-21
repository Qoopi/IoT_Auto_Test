class AWSCredentials {
  var accessKeyId: String = null //required for request and for sign
  var secretAccessKey: String = null //required for sign
  var sessionToken: String = null //required for request
  override def toString: String = {
    return "AWSCredentials{" + "accessKeyId='" + accessKeyId + '\'' + ", secretAccessKey='" + secretAccessKey + '\'' + ", sessionToken='" + sessionToken + '\'' + '}'
  }

  def getAccessKeyId: String = {
    return accessKeyId
  }

  def setAccessKeyId(accessKeyId: String) {
    this.accessKeyId = accessKeyId
  }

  def getSecretAccessKey: String = {
    return secretAccessKey
  }

  def setSecretAccessKey(secretAccessKey: String) {
    this.secretAccessKey = secretAccessKey
  }

  def getSessionToken: String = {
    return sessionToken
  }

  def setSessionToken(sessionToken: String) {
    this.sessionToken = sessionToken
  }
}