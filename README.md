### 1. Create a DynamoDB table for storing mediainfo outputs

Use the console to create a DyanmoDB table called `MediainfoTable`. 

1. Select the Region you've chosen to use for this workshop from the dropdown.

1. In the AWS Management Console choose **Services** then select **DynamoDB** under Storage.

1. Click on the **Create Table** button

1. Provide a name for your table such as  `MediainfoTable` in the **Table name** box.
2. Type `jobId` in the **Primary key** box
3. Check the **Add sort key** radio button
4. Fill in the sort key box with `timestamp` and change the type to **Number** in the dropdown
5. Leave everything else as Default and click **Create**
7. In the **Overview** tab, select the **Manage TTL** link
8. Type in `timestampTTL` in the box and click **Continue**
