class AWSURI {
  private var method: String = null
  private var serviceName: String = null
  private var regionName: String = null
  private var host: String = null
  private var canonicalUri: String = null
  private var canonicalQueryString: String = null
  private var fullURL: String = null

  override def toString: String = {
    return "AWSURI{" + "method='" + method + '\'' + ", serviceName='" + serviceName + '\'' + ", regionName='" + regionName + '\'' + ", host='" + host + '\'' + ", canonicalUri='" + canonicalUri + '\'' + ", canonicalQueryString='" + canonicalQueryString + '\'' + ", fullURL='" + fullURL + '\'' + '}'
  }

  def getMethod: String = {
    return method
  }

  def setMethod(method: String) {
    this.method = method
  }

  def getServiceName: String = {
    return serviceName
  }

  def setServiceName(serviceName: String) {
    this.serviceName = serviceName
  }

  def getRegionName: String = {
    return regionName
  }

  def setRegionName(regionName: String) {
    this.regionName = regionName
  }

  def getHost: String = {
    return host
  }

  def setHost(host: String) {
    this.host = host
  }

  def getCanonicalUri: String = {
    return canonicalUri
  }

  def setCanonicalUri(canonicalUri: String) {
    this.canonicalUri = canonicalUri
  }

  def getCanonicalQueryString: String = {
    return canonicalQueryString
  }

  def setCanonicalQueryString(canonicalQueryString: String) {
    this.canonicalQueryString = canonicalQueryString
  }

  def getFullURL: String = {
    return fullURL
  }

  def setFullURL(fullURL: String) {
    this.fullURL = fullURL
  }
}