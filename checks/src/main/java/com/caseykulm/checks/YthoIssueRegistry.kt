package com.caseykulm.checks

import com.android.tools.lint.client.api.IssueRegistry
import com.android.tools.lint.detector.api.CURRENT_API

class YthoIssueRegistry : IssueRegistry() {
    override val issues = mutableListOf(ExplicitStyleCheck.ISSUE)

    override val api = CURRENT_API
}