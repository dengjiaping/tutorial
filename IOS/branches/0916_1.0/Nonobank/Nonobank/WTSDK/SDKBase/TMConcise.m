//
//  TMConcise.m
//  TBWantu
//
//  Created by huangxiaowei on 12-9-14.
//  Copyright (c) 2012年 Bo Xiu：xiubo2008@gmail.com. All rights reserved.
//

#import "TMConcise.h"



@implementation TMPagedArray

@synthesize currentPage = _currentPage;
@synthesize totalPage = _totalPage;
@synthesize array = _array;


+ (id)array {
    TMPagedArray *pagedArray = [[TMPagedArray alloc] init];
    return pagedArray;
}
@end



@implementation TMCursorArray

@synthesize cursor = _cursor;
@synthesize hasMore = _hasMore;
@synthesize array = _array;


+ (id)array {
    TMCursorArray *cursorArray = [[TMCursorArray alloc] init];
    return cursorArray;
}
@end

@implementation NSDictionary (ForJsonNull)

- (id)objectOrNilForKey:(id)aKey {
    id object = [self objectForKey:aKey];
    if(object == [NSNull null]) {
        return nil;
    }
    return object;
}

- (NSNumber *)numberOrNilForKey:(id)aKey {
    id object = [self objectForKey:aKey];
    if([object isKindOfClass:[NSNumber class]]) {
        return object;
    }
    return nil;
}

- (NSDate *)dateOrNilForKey:(id)aKey {
    id object = [self objectForKey:aKey];
    if([object isKindOfClass:[NSNumber class]]) {
        return [NSDate dateWithTimeIntervalSince1970:[object longLongValue]/1000];
    }
    return nil;
}

@end

@implementation NSMutableDictionary (SetNilForKey)

- (void)setObjectOrNil:(id)anObject forKey:(id)aKey {
    if(!anObject) {
        [self removeObjectForKey:aKey];
        return;
    }
    [self setObject:anObject forKey:aKey];
}

@end
