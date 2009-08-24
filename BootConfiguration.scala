/* sbt -- Simple Build Tool
 * Copyright 2009 Mark Harrah
 */
 package xsbt.boot

// project/boot/                [BootDirectoryName]
//     scala-<version>/    [baseDirectoryName]
//          lib/                      [ScalaDirectoryName]
//          sbt-<version>/  [sbtDirectoryName]
//
// see also ProjectProperties for the set of constants that apply to the build.properties file in a project
private object BootConfiguration
{
	val SbtMainClass = "xsbt.Main"

	// these are the module identifiers to resolve/retrieve
	val ScalaOrg = "org.scala-lang"
	val SbtOrg = "org.scala-tools.sbt"
	val CompilerModuleName = "scala-compiler"
	val LibraryModuleName = "scala-library"
	val SbtModuleName = "xsbt"
	val MainSbtComponentID = "default"

	/** The Ivy conflict manager to use for updating.*/
	val ConflictManagerName = "strict"
	/** The name of the local Ivy repository, which is used when compiling sbt from source.*/
	val LocalIvyName = "local"
	/** The pattern used for the local Ivy repository, which is used when compiling sbt from source.*/
	val LocalPattern = "[organisation]/[module]/[revision]/[type]s/[artifact].[ext]"
	/** The artifact pattern used for the local Ivy repository.*/
	def LocalArtifactPattern = LocalPattern
	/** The Ivy pattern used for the local Ivy repository.*/
	def LocalIvyPattern = LocalPattern

	/** The class name prefix used to hide the Scala classes used by this loader from sbt
	* and the project definition*/
	val ScalaPackage = "scala."
	/** The class name prefix used to hide the Ivy classes used by this loader from sbt
	* and the project definition*/
	val IvyPackage = "org.apache.ivy."
	/** The class name prefix used to hide the sbt launcher classes from sbt and the project definition.
	* Note that access to xsbti classes are allowed.*/
	val SbtBootPackage = "xsbt.boot."
	/** The loader will check that these classes can be loaded and will assume that their presence indicates
	* sbt and its dependencies have been downloaded.*/
	val TestLoadSbtClasses = "xsbt.Main" :: "org.apache.ivy.Ivy" :: Nil
	/** The loader will check that these classes can be loaded and will assume that their presence indicates
	* the Scala compiler and library have been downloaded.*/
	val TestLoadScalaClasses = "scala.ScalaObject" :: "scala.tools.nsc.GenericRunnerCommand" :: Nil

	val ProjectDirectoryName = "project"
	val BootDirectoryName = "boot"
	val BuildPropertiesName ="build.properties"
	val ScalaHomeProperty = "scala.home"
	val UpdateLogName = "update.log"

	val DefaultIvyConfiguration = "default"

	/** The base URL to use to resolve sbt for download. */
	val sbtRootBase = "http://simple-build-tool.googlecode.com/svn/artifacts/"
	/** The name of the directory within the boot directory to retrieve scala to. */
	val ScalaDirectoryName = "lib"
	/** The Ivy pattern to use for retrieving the scala compiler and library.  It is relative to the directory
	* containing all jars for the requested version of scala. */
	val scalaRetrievePattern = ScalaDirectoryName + "/[artifact].[ext]"

	/** The Ivy pattern to use for retrieving sbt and its dependencies.  It is relative to the directory
	* containing all jars for the requested version of scala. */
	def sbtRetrievePattern(sbtVersion: String) = sbtDirectoryName(sbtVersion) + "/[conf]/[artifact]-[revision].[ext]"
	/** The Ivy pattern to use for resolving sbt and its dependencies from the Google code project.*/
	def sbtResolverPattern(scalaVersion: String) = sbtRootBase + "[revision]/[type]s/[artifact].[ext]"
	/** The name of the directory to retrieve sbt and its dependencies to.*/
	def sbtDirectoryName(sbtVersion: String) = SbtModuleName + "-" + sbtVersion
	/** The name of the directory in the boot directory to put all jars for the given version of scala in.*/
	def baseDirectoryName(scalaVersion: String) = "scala-" + scalaVersion
}
private object ProxyProperties
{
	val HttpProxyEnv = "http_proxy"
	val HttpProxyUser = "http_proxy_user"
	val HttpProxyPassword = "http_proxy_pass"

	val ProxyHost = "http.proxyHost"
	val ProxyPort = "http.proxyPort"
	val ProxyUser = "http.proxyUser"
	val ProxyPassword = "http.proxyPassword"
}