//
//  GesturePasswordController.h
//  GesturePassword
//




#import <UIKit/UIKit.h>
#import "TentacleView.h"
#import "GesturePasswordView.h"

@interface GesturePasswordController : UIViewController <VerificationDelegate,ResetDelegate,GesturePasswordDelegate,UIAlertViewDelegate>

- (void)clear;

- (BOOL)exist;

@end
