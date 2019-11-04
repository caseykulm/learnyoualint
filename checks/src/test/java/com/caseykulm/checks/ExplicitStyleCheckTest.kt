package com.caseykulm.checks

import com.android.tools.lint.checks.infrastructure.LintDetectorTest
import org.junit.Test
import java.io.File

class ExplicitStyleCheckTest : LintDetectorTest() {
    override fun getIssues() = YthoIssueRegistry().issues
    override fun getDetector() = ExplicitStyleCheck()

    @Test
    fun testGivenModelcStyle_WhenScanLayoutFile_ThenError() {
        val xmlStr = File("src/test/resources/taco_bell_fail.xml").readText().also { println(it) }
        val file = xml("example_model_c_error.xml", xmlStr)

        val result = lint()
            .files(file)
            .issues(ExplicitStyleCheck.ISSUE)
            .run()

        result.expectErrorCount(1)
    }
}