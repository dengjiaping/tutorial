//
//  WTResponseHandler.h
//  TBWantu
//
//  Created by huangxiaowei on 12-9-10.
//  Copyright (c) 2012年 Bo Xiu：xiubo2008@gmail.com. All rights reserved.
//

#import <Foundation/Foundation.h>
#import "TMRequest.h"

typedef enum{
    WTResultTypeData,
    WTResultTypeBool,
    WTResultTypeNumber,
	WTResultTypeSingleObject,   // Single Object
	WTResultTypeArray,          // Array of objects
    WTResultTypePagedArray,      // Array wit page info.
    WTResultTypeCursorArray,
    WTResultTypeCategoryArray,
    WTResultTypeItemArray,
}WTResultType;

@interface WTResponseHandler : NSObject <TMResponseHandler> {
    Class _resultClass;
    WTResultType _resultType;
}

+ (id)handlerWithResultClass:(Class)aClass andType:(WTResultType)aType;

@end

