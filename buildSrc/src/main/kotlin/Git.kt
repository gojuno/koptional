import org.gradle.api.Project
import java.io.ByteArrayOutputStream
import java.nio.charset.Charset

internal fun gitTag(project: Project): String {
    val gitOutput = ByteArrayOutputStream()

    val gitResult = project.exec {
        commandLine = listOf("git", "tag", "--list", "--points-at", "HEAD")
        standardOutput = gitOutput
    }

    check(gitResult.exitValue == 0) {
        "Getting Git tag: execution resulted in an error (${gitResult.exitValue})"
    }

    val tags = gitOutput.toString(Charset.defaultCharset().name()).split(System.lineSeparator())

    check(tags.size == 1) {
        "Getting Git tag: multiple tags were detected: $tags"
    }

    return tags.first()
}
