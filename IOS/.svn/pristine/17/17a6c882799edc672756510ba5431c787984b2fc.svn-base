//
//  GesturePasswordController.m
//  GesturePassword
//


#import <Security/Security.h>
#import <CoreFoundation/CoreFoundation.h>

#import "GesturePasswordController.h"


#import "KeychainItemWrapper/KeychainItemWrapper.h"

@interface GesturePasswordController ()

@property (nonatomic,strong) GesturePasswordView * gesturePasswordView;

@end

@implementation GesturePasswordController {
    NSString * previousString;
    NSString * password;
}

@synthesize gesturePasswordView;

- (id)initWithNibName:(NSString *)nibNameOrNil bundle:(NSBundle *)nibBundleOrNil
{
    self = [super initWithNibName:nibNameOrNil bundle:nibBundleOrNil];
    if (self) {
        // Custom initialization
    }
    return self;
}

- (void)viewDidLoad
{
    [super viewDidLoad];
    // Do any additional setup after loading the view.
    previousString = [NSString string];
    KeychainItemWrapper * keychin = [[KeychainItemWrapper alloc]initWithIdentifier:@"Gesture" accessGroup:nil];
    password = [keychin objectForKey:(__bridge id)kSecValueData];
    NSLog(@"-------------password:%@",password);
    if ([password isEqualToString:@""]) {
        [self reset];
    }
    else {
        [self verify];
    }
}

- (void)didReceiveMemoryWarning
{
    [super didReceiveMemoryWarning];
    // Dispose of any resources that can be recreated.
}


#pragma mark - 验证手势密码
- (void)verify{
    gesturePasswordView = [[GesturePasswordView alloc]initWithFrame:[UIScreen mainScreen].bounds];
    [gesturePasswordView.tentacleView setRerificationDelegate:self];
    [gesturePasswordView.tentacleView setStyle:1];
    [gesturePasswordView setGesturePasswordDelegate:self];
    [gesturePasswordView.state setTextColor:[UIColor colorWithRed:2/255.f green:174/255.f blue:240/255.f alpha:1]];
    [gesturePasswordView.state setText:@"请输入你的手势"];
    [self.view addSubview:gesturePasswordView];
}

#pragma mark - 重置手势密码
- (void)reset{
    gesturePasswordView = [[GesturePasswordView alloc]initWithFrame:[UIScreen mainScreen].bounds];
    [gesturePasswordView.tentacleView setResetDelegate:self];
    [gesturePasswordView.tentacleView setStyle:2];
//    [gesturePasswordView.imgView setHidden:YES];
    [gesturePasswordView.forgetButton setHidden:YES];
    [gesturePasswordView.changeButton setHidden:YES];
     [gesturePasswordView.state setTextColor:[UIColor colorWithRed:2/255.f green:174/255.f blue:240/255.f alpha:1]];
    [gesturePasswordView.state setText:@"验证成功，请输入新的手势"];
    [self.view addSubview:gesturePasswordView];
}

#pragma mark - 判断是否已存在手势密码
- (BOOL)exist{
    KeychainItemWrapper * keychin = [[KeychainItemWrapper alloc]initWithIdentifier:@"Gesture" accessGroup:nil];
    password = [keychin objectForKey:(__bridge id)kSecValueData];
    if ([password isEqualToString:@""])return NO;
    return YES;
}

#pragma mark - 清空记录
- (void)clear{
    KeychainItemWrapper * keychin = [[KeychainItemWrapper alloc]initWithIdentifier:@"Gesture" accessGroup:nil];
    [keychin resetKeychainItem];
}

- (BOOL)verification:(NSString *)result{
    if ([result isEqualToString:password]) {
        [gesturePasswordView.state setTextColor:[UIColor colorWithRed:2/255.f green:174/255.f blue:240/255.f alpha:1]];
        [gesturePasswordView.state setText:@"输入正确"];
        //清除引用计数
        [[NSUserDefaults standardUserDefaults] setInteger:0 forKey:@"GesturePwd"];
        //[self presentViewController:(UIViewController) animated:YES completion:nil];
        //[self.navigationController popViewControllerAnimated:YES];
        [self reset];
        return YES;
    }
    //增加引用计数
    int gesturePwd = [[[NSUserDefaults standardUserDefaults] objectForKey:@"GesturePwd"] integerValue];
    NSLog(@"gesturePwd:%d",gesturePwd);
    if (gesturePwd > 3) {
        UIAlertView *alert = [[UIAlertView alloc] initWithTitle:@"" message:@"你已连续5次输错手势，请重新登录。" delegate:self cancelButtonTitle:@"确定" otherButtonTitles:nil, nil];
        [alert show];
//        self.view.userInteractionEnabled = NO;
    }else{
        [gesturePasswordView.state setTextColor:[UIColor redColor]];
        NSString *passwordStr = [NSString stringWithFormat:@"密码错误，还可以输入%d次",(4-gesturePwd)];
        [gesturePasswordView.state setText:passwordStr];
        ++gesturePwd;
        [[NSUserDefaults standardUserDefaults] setInteger:gesturePwd forKey:@"GesturePwd"];
//        self.view.userInteractionEnabled = NO;
    }

    return NO;
}

- (BOOL)resetPassword:(NSString *)result{
    if ([previousString isEqualToString:@""]) {
        previousString=result;
        [gesturePasswordView.tentacleView enterArgin];
        [gesturePasswordView.state setTextColor:[UIColor colorWithRed:2/255.f green:174/255.f blue:240/255.f alpha:1]];
        [gesturePasswordView.state setText:@"请验证输入密码"];
        return YES;
    }
    else {
        if ([result isEqualToString:previousString]) {
            KeychainItemWrapper * keychin = [[KeychainItemWrapper alloc]initWithIdentifier:@"Gesture" accessGroup:nil];
            [keychin setObject:@"<帐号>" forKey:(__bridge id)kSecAttrAccount];
            [keychin setObject:result forKey:(__bridge id)kSecValueData];
            //[self presentViewController:(UIViewController) animated:YES completion:nil];
            [gesturePasswordView.state setTextColor:[UIColor colorWithRed:2/255.f green:174/255.f blue:240/255.f alpha:1]];
            [gesturePasswordView.state setText:@"已保存手势密码"];
            [self.navigationController popViewControllerAnimated:YES];
            return YES;
        }
        else{
            previousString =@"";
            [gesturePasswordView.state setTextColor:[UIColor redColor]];
            [gesturePasswordView.state setText:@"两次密码不一致，请重新输入"];
            return NO;
        }
    }
}

#pragma mark - 改变手势密码
- (void)change{
    
}

#pragma mark - 忘记手势密码
- (void)forget{
    UIAlertView *alert = [[UIAlertView alloc] initWithTitle:@"" message:@"忘记手势密码，需要重新登录。" delegate:self cancelButtonTitle:@"取消" otherButtonTitles:@"重新登录", nil];
    [alert show];
}

- (void)alertView:(UIAlertView *)alertView clickedButtonAtIndex:(NSInteger)buttonIndex{
    switch (buttonIndex) {
        case 0:
            break;
        case 1:
            NSLog(@"需要重新登录");
            break;
        default:
            break;
    }
}


/*
#pragma mark - Navigation

// In a storyboard-based application, you will often want to do a little preparation before navigation
- (void)prepareForSegue:(UIStoryboardSegue *)segue sender:(id)sender
{
    // Get the new view controller using [segue destinationViewController].
    // Pass the selected object to the new view controller.
}
*/

@end
