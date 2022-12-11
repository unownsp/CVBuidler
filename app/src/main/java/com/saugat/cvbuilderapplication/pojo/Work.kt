package com.saugat.cvbuilderapplication.pojo

data class Work(
    val companyName: String,
    val fromDate: String,
    val toDate: String,
    val location: String,
    val logo: String,
    val roles: String
) {
    companion object {
        fun getWorkList() : MutableList<Work> {
            return mutableListOf(
                Work(
                    "Nectar Digit",
                    "Feb 2019",
                    "Jan 2022",
                    "Kathmandu, Nepal",
                    "https://www.nectardigit.com//uploads/photos/logo/site-logo.png",
                    "Gather requirement from the client, Discuss a solution with the team members, implement the solution and deploy the application to play store."
                ),
                Work(
                    "Dymanic Softtech (Nerku)",
                    "Jan 2017",
                    "Nov 2018",
                    "Pokhara, Nepal",
                    "https://nerku.com/web/image/website/1/logo/Nerku%20%7C%20ERP%20Implementation%20Company%20In%20Nepal?unique=677781d",
                    "Implement the task given as efficiently as possible"
                ),
                Work(
                    "NITEC",
                    "March 2016",
                    "Oct 2016",
                    "Pokhara, Nepal",
                    "https://media-exp1.licdn.com/dms/image/C560BAQFH-l1h_kCA3g/company-logo_200_200/0/1614245037987?e=1678924800&v=beta&t=WQhTSC9IuHjJ9zOx1syireddMAxbncEZ_MW90MJkZoU",
                    "build job seeker and employer application"
                ),
            )
        }
    }
}