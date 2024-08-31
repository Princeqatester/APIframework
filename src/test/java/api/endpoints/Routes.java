package api.endpoints;
// Create stage(Post)--->https://app.adamx.ai/api/admin/stages
// Get stages(Get)---->https://app.adamx.ai/api/admin/stages
// Edit stage(Put)---->https://app.adamx.ai/api/admin/stages/{stageid}
//delete stage--->https://app.adamx.ai/api/admin/stages
public class Routes {
public static String base_url="https://app.adamx.ai/api/admin";
// Stage module url
public static String post_stage=base_url+"/stages";
public static String get_stage=base_url+"/stages";
public static String put_stage=base_url+"/stages/{stageid}";
public static String del_stage=base_url+"/stages";
//Added a comment to check will it come there in local code or not
}
