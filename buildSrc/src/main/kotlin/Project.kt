import org.gradle.api.Project

internal fun Project.gitVersion(): String {
    val gitTag = gitTag(this)

    return if (gitTag.startsWith("v")) {
        gitTag.substring(1)
    } else {
        "development"
    }
}
