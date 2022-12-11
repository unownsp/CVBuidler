package com.saugat.cvbuilderapplication.pojo

data class Certification(
    val logo: String,
    val name: String
) {
    companion object {
        fun getCertificateList(): MutableList<Certification> {
            return mutableListOf(
                Certification(
                    "https://upload.wikimedia.org/wikipedia/commons/thumb/d/d7/Android_robot.svg/872px-Android_robot.svg.png",
                    "Android Application Development"
                ),
                Certification(
                    "https://static1.xdaimages.com/wordpress/wp-content/uploads/2018/02/Flutter-Framework-Feature-Image-Background-Colour.png",
                    "Flutter Application Development"
                ),
                Certification(
                    "https://git-scm.com/images/logos/downloads/Git-Icon-1788C.png",
                    "Git Basics"
                )
            )
        }
    }
}