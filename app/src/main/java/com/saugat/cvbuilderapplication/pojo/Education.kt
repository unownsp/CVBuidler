package com.saugat.cvbuilderapplication.pojo

data class Education(
    val collegeName: String,
    val program: String,
    val logo: String
) {

    companion object {
        fun getEducationList() : MutableList<Education> {
            return mutableListOf(
                Education(
                    "Maharishi Internation University",
                    "Master's in Computer Science",
                    "https://maharishischool.org/wp-content/uploads/MaharishiSchoolTreeLogo-8cc541-green.jpg"
                ),
                Education(
                    "Gandaki College of Engineering and Science",
                    "Bachelor's in Software Engineering",
                    "https://scontent-iad3-1.xx.fbcdn.net/v/t39.30808-6/301504146_463775375762783_7541126068528463632_n.png?_nc_cat=101&ccb=1-7&_nc_sid=09cbfe&_nc_ohc=R810GgJdJhYAX-08W3J&_nc_ht=scontent-iad3-1.xx&oh=00_AfClMZIW744aaNS8yPFhbgTxiV6M54fpz19Aj9EUUbURgA&oe=6399E415"
                ),
                Education(
                    "Gandaki Higher Secondary boarding School",
                    "+2 Science",
                    "https://gbshostel.com/wp-content/uploads/2022/04/cropped-Logo-National-School-300x290.jpg"
                )
            )
        }
    }
}