//
//  PPLockView.m
//  GestureLock

//
//  Created by anshuo.lee on 13-4-5.
//
//

#import "PPLockView.h"
//#import "TTViewController.h"

#import "NNBAppDelegate.h"
 
#define IS_IPHONE_5 [[[UIDevice currentDevice] systemVersion] floatValue] >= 5.0

#define startY 170
#define startX 40
#define PaddingX 45
#define PaddingY 25
#define Width 50
#define Height 50

static CGPoint lockPos[9] = {{startX, startY},{startX + Width + PaddingX, startY},{startX + Width*2 + PaddingX*2, startY},{startX, startY+Height+PaddingY},{startX + Width + PaddingX, startY+Height+PaddingY},{startX + Width*2 + PaddingX*2, startY+Height+PaddingY},{startX, startY+Height*2+PaddingY*2},{startX + Width + PaddingX, startY+Height*2+PaddingY*2},{startX + Width*2 + PaddingX*2, startY+Height*2+PaddingY*2}};
BOOL gestureflag=NO;
BOOL isEnd = NO;            //是否为最后一个点
CGPoint endPoint;           //最后一个点的坐标
NSString *string=nil;
NSMutableArray *array;
@implementation PPLockView
@synthesize delegate = _delegate;
@synthesize passwordArray;
- (id)initWithFrame:(CGRect)frame
{
    self = [super initWithFrame:frame];
    if (self) {
        // Initialization code
		_selectedPointArray = [[NSMutableArray alloc]init];
		_passwd = [[NSMutableString alloc]init];
        passwordArray=[[NSMutableArray alloc] init];
        array=[[NSMutableArray alloc]init];
    }
    return self;
}

- (void)dealloc
{
	//[_selectedPointArray release];
	_selectedPointArray = nil;
	
	//[_passwd release];
	_passwd = nil;
	//[super dealloc];
}


/**
 
// This method temporarily without drawing a line
 
- (CGPathRef)linePathStartAt:(CGPoint)startPoint End:(CGPoint)endPoint With:(CGFloat)lineWidth
{
	CGMutablePathRef path = CGPathCreateMutable();
	CGPathMoveToPoint(path, nil, startPoint.x, startPoint.y);
	CGPathAddLineToPoint(path, nil, endPoint.x, endPoint.y);
	CGPathCloseSubpath(path);
	return path;
}
*/

- (void)touchesMoved:(NSSet *)touches withEvent:(UIEvent *)event
{
	UITouch *touch = [touches anyObject];
	currentPoint = [touch locationInView:self];
	isEnd=NO;
	for (int i = 0; i < 9; i++) {
		CGPoint p = lockPos[i];
		CGRect rect = CGRectMake(p.x, p.y, Width, Height);
		if(CGRectContainsPoint(rect, currentPoint))                 //当前点在这个所在的点内
		{
			CGPoint ap = CGPointMake(p.x+Width/2, p.y+Height/2);    //制作一个点 (中心点)
			NSString *curstr = NSStringFromCGPoint(ap);             //转成nsstring
			if(![_selectedPointArray containsObject:curstr])        //如果当前点不在选择的数组里
			{
				[_selectedPointArray addObject:curstr];             //把当前点添加到选择点里
				[_passwd appendFormat:@"%d", i];                    //密码加上当前
                
                NSString *strPassWord=[NSString stringWithFormat:@"%d",i];
                NSLog(@"@@@%@",strPassWord);
                [passwordArray addObject:strPassWord];              //密码数组
                
			}
		}
	}
	
 	[self setNeedsDisplay];                                         //重新绘制
}

- (void)touchesEnded:(NSSet *)touches withEvent:(UIEvent *)event
{
    
    UITouch *touch = [touches anyObject];
	endPoint = [touch locationInView:self];
    
    
    isEnd = YES;
    
    NSLog(@"%d",[_passwd length]);                                  //得到密码长度
    
    if([_passwd length] > 0 && [_delegate respondsToSelector:@selector(lockViewUnlockWithPasswd:)])
    {
        
        NNBAppDelegate *appDelegate = (NNBAppDelegate *)[[UIApplication sharedApplication] delegate];
        //        appdelegate.inputCount++;
      //  int lockNum = [ReferenceUtils tryUnLockCount];
        
//        UIView *pLockView = [self superview];
//        UILabel *tipLbl = (UILabel *)[pLockView viewWithTag:846745];
//        
//        
//        if(appDelegate.isLock)
//        {
//            [ReferenceUtils setTryUnLockCount:++lockNum];
//            tipLbl.text = [NSString stringWithFormat:@"密码错误,还可以再输入%d次",5 -lockNum];
//        }
//        
//        if(lockNum >= 5)
//        {
//            tipLbl.text = @"请通过账号解除手势密码";
//            BOCBaseCustomAlertView *baseAlert=[BOCBaseCustomAlertView viewFromNib];
//            baseAlert.delegate=self;
//            [baseAlert showInViewMessage:@"您输入手势密码错误超过5次，系统已将手势密码删除，请重新登录" state:FALSE];
//            
//            return;
//        }
        
        [_delegate lockViewUnlockWithPasswd:_passwd];
    }
    
    [[NSNotificationCenter defaultCenter] postNotificationName:@"gesture" object:passwordArray];    //通知
    
    if ([_passwd isEqualToString:[self readfile]]) {                //如果密码和读取文件的长度一样
        [self cleanMyObject];                                       //密码为空,显示
    }
    else
    {
        gestureflag=YES;                                           //为真
        [self setNeedsDisplay];                                     //设置显示
    }
}




//- (void) ittCustomAlertViewDidConfirm:(BOCBaseCustomAlertView*)alertView
//{
//    
//    
//    TTViewController *loginCtrl = [[TTViewController alloc] init];
//    loginCtrl.currentlyPage=4;
//    
//    
//    
//    PPRevealSideViewController *rrvelCtrl = (PPRevealSideViewController *)[[[UIApplication sharedApplication] keyWindow] rootViewController];
//    UINavigationController *navCtrl = (UINavigationController *)[rrvelCtrl rootViewController];
//    
//    BaseAbroadVC *homeCtrl = (BaseAbroadVC *)[navCtrl topViewController];
//    NSLog(@"topCtrl:%@",homeCtrl);
//    homeCtrl.landOrLogin_Int = 4444;
//    
//    NSLog(@"homeCtrl navCtrl:%@",[homeCtrl navigationController]);
//    [self disMissLockView];
//    [navCtrl pushViewController:loginCtrl animated:YES];
//    
//}

-(void)cleanMyObject
{
    [_selectedPointArray removeAllObjects];
	[_passwd setString:@""];
    [self setNeedsDisplay];
}

-(void)reloadGestureView:(NSNotification*)object
{
    string=(NSString*)object;
}

// Only override drawRect: if you perform custom drawing.
// An empty implementation adversely affects performance during animation.

- (void)drawRect:(CGRect)rect
{
    
    //    UIImage *back = [UIImage imageNamed:@"getsture_backImg.png"];
    //    [back drawInRect:self.bounds];
    CGContextRef context = UIGraphicsGetCurrentContext();
    CGContextSetLineWidth(context, 7.0f);
    if (gestureflag) {                                                                      //如果两次密码不一样
     //   CGContextSetStrokeColorWithColor(context, [[UIColor colorWithHexString:@"d13030"] CGColor]);            //
        
        CGContextSetStrokeColorWithColor(context, [[UIColor colorWithRed:.4 green:.7 blue:.3 alpha:.6] CGColor]);
        
        [self performSelector:@selector(cleanMyObject) withObject:nil afterDelay:0.7];
    }
    else
    {
        CGContextSetStrokeColorWithColor(context, [[UIColor colorWithRed:.4 green:.7 blue:.3 alpha:.6] CGColor]);
    }
    
    CGContextSetLineJoin(context, kCGLineJoinRound);
    
    if ([_selectedPointArray count] > 0 )                                                    //如果选择的point数组大于0
    {
        int i = 0;
        for (NSString *posstr in _selectedPointArray)                                       //从选择的数组里选择一个点
        {
            CGPoint p = CGPointFromString(posstr);                                          //字符转换成点
            if (i == 0)                                                                     //如果为 0
            {
                CGContextMoveToPoint(context, p.x, p.y);                                    //把当前点设为起点
            }
            else
            {
                CGContextAddLineToPoint(context, p.x, p.y);                                 //把当前点设为终点
                CGContextStrokePath(context);
                CGContextMoveToPoint(context, p.x, p.y);
            }
            
            i++;
        }
        
        if (isEnd) {                                                                        //如果是最后一个点
            
        }else
        {
            CGContextAddLineToPoint(context, currentPoint.x, currentPoint.y);
            CGContextStrokePath(context);
        }
    }
    
    if (gestureflag) {
        for (int i = 0; i < 9; i++) {
            CGPoint p = lockPos[i];
            
            CGPoint ap = CGPointMake(p.x+Width/2, p.y+Height/2);
            NSString *curstr = NSStringFromCGPoint(ap);
            if(![_selectedPointArray containsObject:curstr])
            {
                UIImage *img = [UIImage imageNamed:@"1.png"];
                [img drawAtPoint:CGPointMake(p.x, p.y)];
            }
            else
            {
                UIImage *img = [UIImage imageNamed:@"2.png"];
                [img drawAtPoint:CGPointMake(p.x, p.y)];
                
            }
            
        }
        gestureflag=NO;
    }
    else
    {
        for (int i = 0; i < 9; i++) {
            CGPoint p = lockPos[i];
            
            CGPoint ap = CGPointMake(p.x+Width/2, p.y+Height/2);
            NSString *curstr = NSStringFromCGPoint(ap);
            if(![_selectedPointArray containsObject:curstr])
            {
                UIImage *img = [UIImage imageNamed:@"1.png"];
                [img drawAtPoint:CGPointMake(p.x, p.y)];
            }
            else
            {
                UIImage *img = [UIImage imageNamed:@"2.png"];
                [img drawAtPoint:CGPointMake(p.x, p.y)];
                
            }
            
        }
    }
    
}
//密码写入
-(void)write:(NSString*)password
{
    NSArray *paths=NSSearchPathForDirectoriesInDomains(NSDocumentDirectory,NSUserDomainMask,YES);
    NSString *path=[paths objectAtIndex:0];
    NSLog(@"path = %@",path);
    NSString *filename=[path stringByAppendingPathComponent:@"test.plist"];
    NSFileManager* fm = [NSFileManager defaultManager];
    [fm createFileAtPath:filename contents:nil attributes:nil];
    NSDictionary* dic = [NSDictionary dictionaryWithObjectsAndKeys:password,@"1",nil];
    [dic writeToFile:filename atomically:YES];
    
}
//读取密码
-(NSString*)readfile
{
    NSArray *paths=NSSearchPathForDirectoriesInDomains(NSDocumentDirectory,NSUserDomainMask,YES);
    NSString *path=[paths objectAtIndex:0];
    
    NSString *filename=[path stringByAppendingPathComponent:@"test.plist"];
    NSDictionary *dic2=[NSDictionary dictionaryWithContentsOfFile:filename];
    NSString *str=[dic2 objectForKey:@"1"];
    return str;
}
//删除密码
-(void)removeFile
{
    NSFileManager* fm = [NSFileManager defaultManager];
    NSArray *paths=NSSearchPathForDirectoriesInDomains(NSDocumentDirectory,NSUserDomainMask,YES);
    NSString *path=[paths objectAtIndex:0];
    NSString *filename=[path stringByAppendingPathComponent:@"test.plist"];
    [fm removeItemAtPath:filename error:nil];
}

- (void)disMissLockView
{
    [UIView animateWithDuration:0.5 animations:^{
        CGRect frame = self.superview.frame;
        frame.origin.y = IS_IPHONE_5?570:490;
        frame.origin.x = 0;
        self.superview.frame=frame;
        frame=CGRectZero;
    } completion:^(BOOL finished) {
        [self.superview removeFromSuperview];
    }];
}


@end
