#import "FileOpener.h"
#import <Cordova/CDV.h>

#import <QuartzCore/QuartzCore.h>
#import <MobileCoreServices/MobileCoreServices.h>
#import "MainViewController.h"
#import "RDPDFViewController.h"

@implementation FileOpener
@synthesize controller = docController;

- (void) open: (CDVInvokedUrlCommand*)command {
        
    NSString *path = [command.arguments objectAtIndex:0];
    NSString *aCellId = [command.arguments objectAtIndex:1];
    NSData *rootObj = [command.arguments objectAtIndex:2];
    NSString *deviceId = [command.arguments objectAtIndex:3];
    NSString *rcid = [command.arguments objectAtIndex:4];
    NSString *userId = [command.arguments objectAtIndex:5];
    NSString *orgId = [command.arguments objectAtIndex:6];
    NSString *sid = [command.arguments objectAtIndex:7];
    NSString *logKey = [command.arguments objectAtIndex:8];
    NSString *jsonCount = [command.arguments objectAtIndex:9];
    if (jsonCount == (id)[NSNull null]) {
        jsonCount = @"0";
    }
    NSString *logName = [command.arguments objectAtIndex:10];
    NSString *aContentId = [command.arguments objectAtIndex:11];
    
    //set the jsonvalue in userdefaults
    NSUserDefaults *userDefaults = [NSUserDefaults standardUserDefaults];
    [userDefaults setObject:rootObj forKey:@"subsectionJson"];
     [userDefaults setObject:aCellId forKey:@"aCellId"];
    [userDefaults setObject:deviceId forKey:@"deviceId"];
    [userDefaults setObject:rcid forKey:@"rcid"];
    [userDefaults setObject:userId forKey:@"userId"];
    [userDefaults setObject:orgId forKey:@"orgId"];
    [userDefaults setObject:sid forKey:@"sid"];
    [userDefaults setObject:logKey forKey:@"logKey"];
    [userDefaults setObject:jsonCount forKey:@"jsonCount"];
    [userDefaults setObject:logName forKey:@"logName"];
    [userDefaults setObject:aContentId forKey:@"aContentId"];

    [userDefaults synchronize];
    dispatch_async(dispatch_get_global_queue(DISPATCH_QUEUE_PRIORITY_DEFAULT, 0), ^{
      
        NSURL *fileURL = nil;
        fileURL = [NSURL fileURLWithPath:path];
        localFile = fileURL.path;
        dispatch_async(dispatch_get_main_queue(), ^{
            MainViewController *itsMainView = [MainViewController sharedManager];
            itsMainView.pdfPath = path;
            [itsMainView openPDF:nil];
            
        });
    });
}

@end
