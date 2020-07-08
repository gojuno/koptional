import org.gradle.api.Project
import com.jfrog.bintray.gradle.BintrayExtension

fun BintrayExtension.configure(project: Project) {
    user = System.getenv("BINTRAY_USER")
    key = System.getenv("BINTRAY_API_KEY")

    setPublications(PUBLICATION_NAME)

    publish = true

    pkg.apply {
        repo = "maven"
        name = "koptional"

        setLicenses("Apache-2.0")

        issueTrackerUrl = "https://github.com/gojuno/koptional/issues"
        vcsUrl = "https://github.com/gojuno/koptional.git"

        version.apply {
            name = project.gitVersion()
            vcsTag = gitTag(project)

            gpg.apply {
                sign = true
                passphrase = System.getenv("BINTRAY_GPG_PASSPHRASE")
            }
        }
    }
}
