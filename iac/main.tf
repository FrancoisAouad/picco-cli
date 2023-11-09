resource "github_repository" "picco_cli" {
  name        = var.repository_name
  description = var.repository_description
  visibility = var.repository_visibility
}

resource "github_release" "example" {
  repository = var.repository_name
  tag_name = "v0.1.0"
  name = "Latest Release" + var.repository_name
  body = "This is my first release of the project"
  draft = false
}