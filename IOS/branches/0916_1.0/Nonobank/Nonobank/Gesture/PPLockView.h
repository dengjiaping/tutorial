//
//  PPLockView.h
//  GestureLock
//
//  Created by anshuo.lee on 13-4-5.
//

#import <UIKit/UIKit.h>
//#import "RefeGesture.h"
@protocol PPLockViewDelegate;
//#import "ITTXibView.h"
//#import "BOCBaseCustomAlertView.h"

@interface PPLockView : UIView // <ITTCustomAlertViewDelegate>
{
	NSMutableArray *_selectedPointArray;
	CGPoint currentPoint;
	NSMutableString *_passwd;
    NSMutableArray *passwordArray;
}
@property (nonatomic,retain)NSMutableArray *passwordArray;;
@property (nonatomic, assign) id <PPLockViewDelegate> delegate;

-(NSString*)readfile;
-(void)removeFile;
-(void)write:(NSString*)password;

@end

@protocol PPLockViewDelegate <NSObject>

@optional

- (void)lockViewUnlockWithPasswd:(NSString *)pass;

@end